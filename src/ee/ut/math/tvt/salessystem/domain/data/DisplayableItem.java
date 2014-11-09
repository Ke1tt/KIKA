package ee.ut.math.tvt.salessystem.domain.data;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;

/**
 * Base interface for data items, so one JTable can be used to display different entities.
 */
@Entity
@Table(name = "Displayable Item")
public interface DisplayableItem {
	/**
	 * Id of entity.
	 */
	@Id
	@Column(name = "Id", nullable = false)
	public Long getId();
	@Column(name = "Name")
	public String getName();
}
