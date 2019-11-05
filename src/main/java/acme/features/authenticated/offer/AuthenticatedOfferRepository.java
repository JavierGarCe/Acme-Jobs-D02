
package acme.features.authenticated.offer;

import java.util.Collection;

import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import acme.entities.offers.Offer;
import acme.framework.repositories.AbstractRepository;

@Repository
public interface AuthenticatedOfferRepository extends AbstractRepository {

	@Query("select o from Offer o where o.id = ?1")
	Offer findOneById(int id);

	@Query("select o from Offer o where o.deadline > CURRENT_TIMESTAMP") //Only active offers are shown
	Collection<Offer> findManyAll();

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
}
