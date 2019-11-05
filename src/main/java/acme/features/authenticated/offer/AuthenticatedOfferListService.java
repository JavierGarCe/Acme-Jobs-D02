
package acme.features.authenticated.offer;

import java.util.Collection;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import acme.entities.offers.Offer;
import acme.framework.components.Model;
import acme.framework.components.Request;
import acme.framework.entities.Authenticated;
import acme.framework.services.AbstractListService;

@Service
public class AuthenticatedOfferListService implements AbstractListService<Authenticated, Offer> {

	@Autowired
	AuthenticatedOfferRepository repository;


	@Override
	public boolean authorise(final Request<Offer> request) {
		assert request != null;
		return true;
	}

	@Override
	public void unbind(final Request<Offer> request, final Offer entity, final Model model) {
		assert request != null;
		assert entity != null;
		assert model != null;

		request.unbind(entity, model, "title", "deadline", "description", "rewardRange");
	}

	@Override
	public Collection<Offer> findMany(final Request<Offer> request) {
		assert request != null;
		Collection<Offer> result;

		result = this.repository.findManyAll();

		return result;
	}
	public Double stDevMaxActiveOffers() {
		return this.repository.stDevMaxActiveOffer();
	}

	public Double stDevMinActiveOffers() {
		return this.repository.stDevMinActiveOffer();
	}

	public Double minActiveOffer() {
		return this.repository.minActiveOffer();
	}

	public Double maxActiveOffer() {
		return this.repository.maxActiveOffer();
	}

	public Double avgActiveOffer() {
		return (this.repository.avgMinActiveOffer() + this.repository.avgMaxActiveOffer()) / 2;
	}
}
