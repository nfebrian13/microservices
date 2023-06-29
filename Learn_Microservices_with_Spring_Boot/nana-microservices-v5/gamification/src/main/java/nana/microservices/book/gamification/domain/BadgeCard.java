package nana.microservices.book.gamification.domain;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;

@Entity
public class BadgeCard {

	@Id
	@GeneratedValue
	@Column(name = "BADGE_ID")
	private Long badgeId;
	private Long userId;
	private long badgeTimestamp;
	private Badge badge;

	public BadgeCard() {
		super();
	}

	public BadgeCard(Long userId, Badge badge) {
		super();
		this.userId = userId;
		this.badge = badge;
		this.badgeTimestamp = System.currentTimeMillis();

	}

	public BadgeCard(Long badgeId, Long userId, long badgeTimestamp, Badge badge) {
		super();
		this.badgeId = badgeId;
		this.userId = userId;
		this.badgeTimestamp = badgeTimestamp;
		this.badge = badge;
	}

	public Long getBadgeId() {
		return badgeId;
	}

	public void setBadgeId(Long badgeId) {
		this.badgeId = badgeId;
	}

	public Long getUserId() {
		return userId;
	}

	public void setUserId(Long userId) {
		this.userId = userId;
	}

	public long getBadgeTimestamp() {
		return badgeTimestamp;
	}

	public void setBadgeTimestamp(long badgeTimestamp) {
		this.badgeTimestamp = badgeTimestamp;
	}

	public Badge getBadge() {
		return badge;
	}

	public void setBadge(Badge badge) {
		this.badge = badge;
	}

}
