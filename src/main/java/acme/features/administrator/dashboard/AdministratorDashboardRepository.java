
package acme.features.administrator.dashboard;

import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import acme.framework.repositories.AbstractRepository;

@Repository
public interface AdministratorDashboardRepository extends AbstractRepository {

	@Query("select count(*) from Announcement a")
	Integer numberOfAnnouncements();

	@Query("select count(*) from CompanyRecord c")
	Integer numberOfCompanyRecords();

	@Query("select count(*) from InvestorRecord i")
	Integer numberOfInvestorRecords();

	@Query("select count(*) from Offer i")
	Integer numberOfOffers();

	@Query("select count(*) from Requests i")
	Integer numberOfRequests();

	@Query("select avg(minReward.amount) from Offer o where o.deadline >= current_date")
	Double avgMinActiveOffer();

	@Query("select avg(maxReward.amount) from Offer o where o.deadline >= current_date")
	Double avgMaxActiveOffer();

	@Query("select min(minReward.amount) from Offer o where o.deadline >= current_date")
	Double minActiveOffer();

	@Query("select max(maxReward.amount) from Offer o where o.deadline >= current_date")
	Double maxActiveOffer();

	@Query("select stddev(maxReward.amount) from Offer o where o.deadline >= current_date")
	Double stDevMaxActiveOffer();

	@Query("select stddev(minReward.amount) from Offer o where o.deadline >= current_date")
	Double stDevMinActiveOffer();

	@Query("select avg(reward.amount) from Requests r where r.deadline >= current_date")
	Double avgActiveRequests();

	@Query("select min(reward.amount) from Requests r where r.deadline >= current_date")
	Double minActiveRequests();

	@Query("select max(reward.amount) from Requests r where r.deadline >= current_date")
	Double maxActiveRequests();

	@Query("select stddev(reward.amount) from Requests r where r.deadline >= current_date")
	Double stDevActiveRequests();
}
