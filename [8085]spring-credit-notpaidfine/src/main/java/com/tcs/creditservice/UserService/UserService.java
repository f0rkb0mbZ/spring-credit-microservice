package com.tcs.creditservice.UserService;

import java.text.DateFormat;
// import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.time.LocalDate;
import java.time.temporal.ChronoUnit;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import java.util.function.IntPredicate;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.tcs.creditservice.models.Users;
import com.tcs.creditservice.repository.UserRepository;

@Service
public class UserService {

	@Autowired
	private UserRepository usersRepository;


	public void updateOutstandingFine() {
		List<Users> persons = new ArrayList<Users>();

		Iterable<Users> users = usersRepository.findAll();

		Date today = new Date();
		DateFormat df = new SimpleDateFormat("yyyy-MM-dd");
		LocalDate today1 = LocalDate.parse(df.format(today));


		users.forEach(user -> {

			// Date lastpaid = new Date();
			Date lastpaid = user.getLastPaid();
			// try {
			// 	lastpaid = df.parse(user.getLastPaid());
			// } catch (ParseException e) {
			// 	e.printStackTrace();
			// }
			LocalDate lastpaid1 = LocalDate.parse(df.format(lastpaid));
			long diffDays = ChronoUnit.DAYS.between(lastpaid1, today1);
			IntPredicate p = val -> val > 60;
			if (p.test((int) diffDays ) && !(user.isAlreadyFinedExceedingDeadline())) {
				double outstand = user.getOutstandingAmount() * 1.042;
				user.setOutstandingAmount(outstand);
				user.setAlreadyFinedExceedingDeadline(true);
				usersRepository.save(user);
			}

			persons.add(user);
		});
	}
}
