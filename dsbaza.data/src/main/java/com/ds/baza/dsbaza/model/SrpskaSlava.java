package com.ds.baza.dsbaza.model;

import com.ds.baza.dsbaza.model.Constraints.SrpskaSlavaValidatorConstraint;
import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.ToString;
import org.springframework.util.LinkedCaseInsensitiveMap;

import javax.persistence.*;
import java.util.HashSet;
import java.util.Set;

@Data
@Entity
@Table(name = "SRPSKA_SLAVA")
public class SrpskaSlava {
	@SrpskaSlavaValidatorConstraint
	@Column(name = "NAZIV")
	private String naziv;
	@Column(name = "DATUM")
	public String datum;
	@Id
	@GeneratedValue
	@Column(name = "SRPSKA_SLAVA")
	private Long id;


	//@OneToMany(mappedBy = "srpskaSlava")
	//private Set<LicniPodaci> licniPodaci = new HashSet<>();

//	@OneToOne
//	//@JoinColumn(name ="asd")
//	//@Transient
//	private LicniPodaci licniPodaci;



}
