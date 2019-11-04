
package acme.features.administrator.dashboard;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.ModelAndView;

import acme.features.administrator.announcement.AdministratorAnnouncementListService;
import acme.features.authenticated.companyRecord.AuthenticatedCompanyRecordListService;
import acme.features.authenticated.investorRecord.AuthenticatedInvestorRecordListService;
import acme.features.authenticated.offer.AuthenticatedOfferListService;
import acme.features.authenticated.requests.AuthenticatedRequestsListService;
import acme.forms.dashboards.Dashboard;
import acme.framework.controllers.AbstractController;
import acme.framework.entities.Administrator;

@Controller
@RequestMapping("/administrator/dashboard/")
public class AdministratorDashboardController extends AbstractController<Administrator, Dashboard> {

	@Autowired
	private AdministratorAnnouncementListService	listServiceAnnouncement;
	@Autowired
	private AuthenticatedCompanyRecordListService	listServiceCompany;
	@Autowired
	private AuthenticatedInvestorRecordListService	listServiceInvestor;
	@Autowired
	private AuthenticatedRequestsListService		listServiceRequest;
	@Autowired
	private AuthenticatedOfferListService			listServiceOffer;


	@RequestMapping(value = "/display", method = RequestMethod.GET)
	public ModelAndView list() {
		ModelAndView result;
		result = new ModelAndView();
		Integer numberOfAnnoucements = this.listServiceAnnouncement.numberOfAnnouncements();
		Integer numberOfCompanyRecords = this.listServiceCompany.numberOfCompanyRecords();
		Integer numberOfInvestorRecords = this.listServiceInvestor.numberOfInvestorRecords();
		Double minActiveRequests = this.listServiceRequest.minActiveRequests();
		Double maxActiveRequests = this.listServiceRequest.maxActiveRequests();
		Double avgActiveRequests = this.listServiceRequest.avgActiveRequests();
		Double stDevRActiveRequests = this.listServiceRequest.stDevRequests();
		Double minActiveOffers = this.listServiceOffer.minActiveOffer();
		Double maxActiveOffers = this.listServiceOffer.maxActiveOffer();
		Double avgActiveOffers = this.listServiceOffer.avgActiveOffer();
		Double stDevMaxActiveOffers = this.listServiceOffer.stDevMaxActiveOffers();
		Double stDevMinActiveOffers = this.listServiceOffer.stDevMinActiveOffers();
		result.addObject("numberOfAnnoucements", numberOfAnnoucements);
		result.addObject("numberOfCompanyRecords", numberOfCompanyRecords);
		result.addObject("numberOfInvestorRecords", numberOfInvestorRecords);
		result.addObject("minActiveRequests", minActiveRequests);
		result.addObject("maxActiveRequests", maxActiveRequests);
		result.addObject("avgActiveRequests", avgActiveRequests);
		result.addObject("stDevRActiveRequests", stDevRActiveRequests);
		result.addObject("minActiveOffers", minActiveOffers);
		result.addObject("maxActiveOffers", maxActiveOffers);
		result.addObject("avgActiveOffers", avgActiveOffers);
		result.addObject("stDevMaxActiveOffers", stDevMaxActiveOffers);
		result.addObject("stDevMinActiveOffers", stDevMinActiveOffers);

		return result;

	}
}
