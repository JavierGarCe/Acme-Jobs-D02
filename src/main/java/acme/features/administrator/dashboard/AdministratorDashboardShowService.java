
package acme.features.administrator.dashboard;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import acme.forms.dashboards.Dashboard;
import acme.framework.components.Model;
import acme.framework.components.Request;
import acme.framework.entities.Administrator;
import acme.framework.services.AbstractShowService;

@Service
public class AdministratorDashboardShowService implements AbstractShowService<Administrator, Dashboard> {

	@Autowired
	AdministratorDashboardRepository repository;


	@Override
	public boolean authorise(final Request<Dashboard> request) {
		assert request != null;

		return true;
	}

	@Override
	public void unbind(final Request<Dashboard> request, final Dashboard entity, final Model model) {
		assert request != null;
		assert entity != null;
		assert model != null;

		request.unbind(entity, model, "numberOfAnnoucements", "numberOfCompanyRecords", "numberOfInvestorRecords", "minActiveRequests", "maxActiveRequests", "avgActiveRequests", "stDevRActiveRequests", "minActiveOffers", "maxActiveOffers",
			"avgActiveOffers", "stDevMaxActiveOffers", "stDevMinActiveOffers");

	}

	@Override
	public Dashboard findOne(final Request<Dashboard> request) {
		assert request != null;

		Dashboard result = new Dashboard();

		Double minActiveRequests = 0.;
		Double maxActiveRequests = 0.;
		Double avgActiveRequests = 0.;
		Double stDevActiveRequests = 0.;
		Double minActiveOffer = 0.;
		Double maxActiveOffer = 0.;
		Double avgMaxActiveOffer = 0.;
		Double avgMinActiveOffer = 0.;
		Double stDevMaxActiveOffer = 0.;
		Double stDevMinActiveOffer = 0.;

		if (this.repository.numberOfRequests() != 0) {
			minActiveRequests = this.repository.minActiveRequests();
			maxActiveRequests = this.repository.maxActiveRequests();
			avgActiveRequests = this.repository.avgActiveRequests();
			stDevActiveRequests = this.repository.stDevActiveRequests();
		}

		if (this.repository.numberOfOffers() != 0) {
			minActiveOffer = this.repository.minActiveOffer();
			maxActiveOffer = this.repository.maxActiveOffer();
			avgMaxActiveOffer = this.repository.avgMaxActiveOffer();
			avgMinActiveOffer = this.repository.avgMinActiveOffer();
			stDevMaxActiveOffer = this.repository.stDevMaxActiveOffer();
			stDevMinActiveOffer = this.repository.stDevMinActiveOffer();
		}
		result.setNumberOfAnnoucements(this.repository.numberOfAnnouncements());
		result.setNumberOfCompanyRecords(this.repository.numberOfCompanyRecords());
		result.setNumberOfInvestorRecords(this.repository.numberOfInvestorRecords());
		result.setMinActiveRequests(minActiveRequests);
		result.setMaxActiveRequests(maxActiveRequests);
		result.setAvgActiveRequests(avgActiveRequests);
		result.setStDevRActiveRequests(stDevActiveRequests);
		result.setMinActiveOffers(minActiveOffer);
		result.setMaxActiveOffers(maxActiveOffer);
		result.setAvgActiveOffers((avgMaxActiveOffer + avgMinActiveOffer) / 2);
		result.setStDevMaxActiveOffers(stDevMaxActiveOffer);
		result.setStDevMinActiveOffers(stDevMinActiveOffer);
		return result;
	}

}
