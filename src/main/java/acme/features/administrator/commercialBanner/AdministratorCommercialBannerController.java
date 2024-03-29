
package acme.features.administrator.commercialBanner;

import javax.annotation.PostConstruct;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

import acme.entities.banners.CommercialBanner;
import acme.framework.components.BasicCommand;
import acme.framework.controllers.AbstractController;
import acme.framework.entities.Administrator;

@Controller
@RequestMapping("/administrator/commercial-banner/")
public class AdministratorCommercialBannerController extends AbstractController<Administrator, CommercialBanner> {

	@Autowired
	private AdministratorCommercialBannerListService	listService;

	@Autowired
	private AdministratorCommercialBannerShowService	showService;


	@PostConstruct
	private void initialise() {
		super.addBasicCommand(BasicCommand.LIST, this.listService);
		super.addBasicCommand(BasicCommand.SHOW, this.showService);
	}

}
