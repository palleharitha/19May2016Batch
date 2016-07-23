package com.flp.fms.domain;

import java.math.BigDecimal;
//import java.sql.Timestamp;
import java.util.Date;
import java.util.HashSet;
import java.util.Set;

import javax.persistence.*;

@Entity
public class Film
{
	@Id @GeneratedValue(strategy = GenerationType.AUTO)
	@Column(name="film_Id",nullable=false)
	private Short filmId;
	
    @Column(name="title",nullable=false)
	private String title;
    
    @Column(name="description",nullable=false)
	private String description;
    
    @Column(name="release_year",nullable=false)
	@Temporal(TemporalType.DATE)
    private Date releaseYear;
	
	@ManyToOne(fetch = FetchType.LAZY,cascade = {CascadeType.ALL})
	@JoinColumn(name="language_id")
	private Language language;
	
	@Column(name="rental_duration",nullable=false)
	private short rentalDuration;
	
	@Column(name="rental_rate",nullable=false)
	private BigDecimal rentalRate;
	
	@Column(name="length",nullable=false)
	private short length;
	
	@Column(name="replacement_cost",nullable=false)
	private BigDecimal replacementCost;
	
	@Column(name="rating",nullable=false)
	private String rating;
	
	@Column(name="special_features",nullable=false)
	private String specialFeatures;
	
	@ManyToMany(fetch = FetchType.LAZY,cascade = {CascadeType.ALL})
	@JoinTable(name = "film_actor", joinColumns = @JoinColumn(name = "film_id", referencedColumnName = "film_id") , inverseJoinColumns = @JoinColumn(name = "actor_id", referencedColumnName = "actor_id"))
	private Set<Actor> actors = new HashSet<Actor>();
	
	@ManyToOne(fetch = FetchType.LAZY,cascade = {CascadeType.ALL})
	@JoinTable(name = "film_category", joinColumns = @JoinColumn(name = "film_id", referencedColumnName = "film_id") , inverseJoinColumns = @JoinColumn(name = "category_id", referencedColumnName = "category_id"))
	private Category category;
	
	@Column(name="last_update",insertable = false, updatable = false,nullable=false,columnDefinition="TIMESTAMP DEFAULT CURRENT_TIMESTAMP")
	@Temporal(TemporalType.TIMESTAMP)
	private Date lastUpdate;
	
	public Film()
	{
		
	}

	public String getTitle() {
		return title;
	}

	public void setTitle(String title) {
		this.title = title;
	}

	public String getDescription() {
		return description;
	}

	public void setDescription(String description) {
		this.description = description;
	}

	public Date getReleaseYear() {
		return releaseYear;
	}

	public void setReleaseYear(Date releaseYear) {
		this.releaseYear = releaseYear;
	}

	public Language getLanguage() {
		return language;
	}

	public void setLanguage(Language language) {
		this.language = language;
	}

	public short getRentalDuration() {
		return rentalDuration;
	}

	public void setRentalDuration(short rentalDuration) {
		this.rentalDuration = rentalDuration;
	}

	public BigDecimal getRentalRate() {
		return rentalRate;
	}

	public void setRentalRate(BigDecimal rentalRate) {
		this.rentalRate = rentalRate;
	}

	public short getLength() {
		return length;
	}

	public void setLength(short length) {
		this.length = length;
	}

	public BigDecimal getReplacementCost() {
		return replacementCost;
	}

	public void setReplacementCost(BigDecimal replacementCost) {
		this.replacementCost = replacementCost;
	}

	public String getRating() {
		return rating;
	}

	public void setRating(String rating) {
		this.rating = rating;
	}

	public String getSpecialFeatures() {
		return specialFeatures;
	}

	public void setSpecialFeatures(String specialFeatures) {
		this.specialFeatures = specialFeatures;
	}

	public Set<Actor> getActors() {
		return actors;
	}

	public void setActors(Set<Actor> actors) {
		this.actors = actors;
	}

	public Category getCategory() {
		return category;
	}

	public void setCategory(Category category) {
		this.category = category;
	}

	public Date getLastUpdate() {
		return lastUpdate;
	}

	public void setLastUpdate(Date lastUpdate) {
		this.lastUpdate = lastUpdate;
	}

	public Short getFilmId() {
		return filmId;
	}

	@Override
	public String toString() {
		return "Film [filmId=" + filmId + ", title=" + title + ", description=" + description + ", releaseYear="
				+ releaseYear + ", language=" + language + ", rentalDuration=" + rentalDuration + ", rentalRate="
				+ rentalRate + ", length=" + length + ", replacementCost=" + replacementCost + ", rating=" + rating
				+ ", specialFeatures=" + specialFeatures + ", actors=" + actors + ", category=" + category
				+ ", lastUpdate=" + lastUpdate + "]";
	}
	
}