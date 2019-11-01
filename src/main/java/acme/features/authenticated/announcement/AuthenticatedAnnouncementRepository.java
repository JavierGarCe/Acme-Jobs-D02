
package acme.features.authenticated.announcement;

import java.util.Collection;

import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import acme.entities.announcements.Announcement;
import acme.framework.repositories.AbstractRepository;

@Repository
public interface AuthenticatedAnnouncementRepository extends AbstractRepository {

	@Query("select a from Announcement a where a.id= ?1")
	Announcement findOneById(int id);
	@Query("select a from Announcement a where (((month(current_date()) - month(a.moment))=0)or ((month(current_date()) - month(a.moment))=1)and(day(current_date)-day(a.moment)=0)and(current_time-cast(a.moment as time)>=0)or ((month(current_date()) - month(a.moment))=1)and(day(current_date)-day(a.moment)<0))and(year(current_date()) = year(a.moment))")
	Collection<Announcement> findManyAll();
}
