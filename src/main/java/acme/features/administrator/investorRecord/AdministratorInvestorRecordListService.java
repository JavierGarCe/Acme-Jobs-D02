
package acme.features.administrator.investorRecord;

import java.util.Collection;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import acme.entities.investorRecord.InvestorRecord;
import acme.framework.components.Model;
import acme.framework.components.Request;
import acme.framework.entities.Administrator;
import acme.framework.services.AbstractListService;

@Service
public class AdministratorInvestorRecordListService implements AbstractListService<Administrator, InvestorRecord> {

	// Internal state ---------------------------------------------------------

	@Autowired
	AdministratorInvestorRecordRepository repository;


	@Override
	public boolean authorise(final Request<InvestorRecord> request) {
		assert request != null;

		return true;
	}

	@Override
	public void unbind(final Request<InvestorRecord> request, final InvestorRecord entity, final Model model) {
		// TODO Auto-generated method stub
		assert request != null;
		assert entity != null;
		assert model != null;

		request.unbind(entity, model, "name", "sector", "stars");

	}

	@Override
	public Collection<InvestorRecord> findMany(final Request<InvestorRecord> request) {
		assert request != null;
		Collection<InvestorRecord> result;
		result = this.repository.findMany();
		return result;
	}

}
