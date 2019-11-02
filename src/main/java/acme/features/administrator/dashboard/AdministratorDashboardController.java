
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
import acme.framework.controllers.AbstractController;
import acme.framework.entities.Administrator;

@Controller
@RequestMapping("/administrator/dashboard/")
public class AdministratorDashboardController extends AbstractController<Administrator, acme.forms.dashboards.Dashboard> {

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


	public AdministratorDashboardController() {
		super();
	}

	@RequestMapping(value = "/display", method = RequestMethod.GET)

	public ModelAndView list() {
		ModelAndView result;
		result = new ModelAndView();
		Integer numberOfAnnoucements;
		Integer numberOfCompanyRecords;
		Integer numberOfInvestorRecords;
		Double minActiveRequests;
		Double maxActiveRequests;
		Double avgActiveRequests;
		Double stDevRActiveRequests;
		Double minActiveOffers;
		Double maxActiveOffers;
		Double avgActiveOffers;
		Double stDevMaxActiveOffers;
		Double stDevMinActiveOffers;
		numberOfAnnoucements = this.listServiceAnnouncement.numberOfAnnouncements();
		numberOfCompanyRecords = this.listServiceCompany.numberOfCompanyRecords();
		numberOfInvestorRecords = this.listServiceInvestor.numberOfInvestorRecords();
		minActiveRequests = this.listServiceRequest.minActiveRequests();
		maxActiveRequests = this.listServiceRequest.maxActiveRequests();
		avgActiveRequests = this.listServiceRequest.avgActiveRequests();
		stDevRActiveRequests = this.listServiceRequest.stDevRequests();
		minActiveOffers = this.listServiceOffer.minActiveOffer();
		maxActiveOffers = this.listServiceOffer.maxActiveOffer();
		avgActiveOffers = this.listServiceOffer.avgActiveOffer();
		stDevMaxActiveOffers = this.listServiceOffer.stDevMaxActiveOffers();
		stDevMinActiveOffers = this.listServiceOffer.stDevMinActiveOffers();
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
