
package acme.entities.customization;

import java.util.Collection;

import javax.persistence.ElementCollection;
import javax.persistence.Entity;
import javax.persistence.FetchType;

import org.hibernate.validator.constraints.Range;

import acme.framework.entities.DomainEntity;
import lombok.Getter;
import lombok.Setter;

@Entity
@Setter
@Getter
public class Customization extends DomainEntity {

	/**
	 *
	 */
	private static final long	serialVersionUID	= 1L;

	@Range(min = 0, max = 100)
	private Double				threshold;

	@ElementCollection(fetch = FetchType.EAGER)
	private Collection<String>	spamword;

}
