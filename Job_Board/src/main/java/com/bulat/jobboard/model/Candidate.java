package com.bulat.jobboard.model;

import com.bulat.jobboard.service.GettersForCommonFieldsThatAreSearched;
import lombok.*;

import javax.persistence.*;
import java.util.List;

/**
 * The essence of a job search candidate
 * @author Bulat Bilalov
 * @version 1.0
 * @see com.bulat.jobboard.model.BaseEntity
 * @see com.bulat.jobboard.service.GettersForCommonFieldsThatAreSearched
 * @see db.changelog/db.changelog-1.1.xml
 */
@EqualsAndHashCode(callSuper = false)
@Data
@NoArgsConstructor
@AllArgsConstructor
@Builder
@Entity
@Table(name = "vacancy_candidate")
public class Candidate extends BaseEntity implements GettersForCommonFieldsThatAreSearched {

    /** The name of the candidate */
    @Column(name = "first_name")
    private String firstName;

    /** The surname of the candidate*/
    @Column(name = "last_name")
    private String lastName;

    /** Number of years */
    @Column(name = "age")
    private Integer age;

    /** Contact (email) */
    @Column(name = "email")
    private String email;

    /** Candidate description */
    @Column(name = "description", length = 3000)
    private String description;

    /** Country of Residence */
    @ManyToOne(fetch = FetchType.EAGER)
    @JoinColumn(name="country_id")
    private Country country;

    /** City of Residence */
    @ManyToOne(fetch = FetchType.EAGER)
    @JoinColumn(name="city_id")
    private City city;

    /** Candidate gender */
    @Column(name = "gender")
    @Enumerated(EnumType.STRING)
    private Gender gender;

    /** Skill (programming language) */
    @ManyToOne(fetch = FetchType.EAGER)
    @JoinColumn(name="skill_id")
    private Skill skill;

    /** Education (university) */
    @ManyToOne(fetch = FetchType.EAGER)
    @JoinColumn(name="education_id")
    private Education education;

    /** The language you know best */
    @ManyToOne(fetch = FetchType.EAGER)
    @JoinColumn(name="language_id")
    private Language native_language;

    /** Link to prepared images */
    @Column(name = "link_img")
    private String link_img;

    /** Link to the unique identifier of the registered user */
    @Column(name = "user_id")
    private Long userId;

    /** Feedback left candidates to the site */
    @ManyToMany(fetch = FetchType.EAGER)
    @JoinTable(name = "candidate_company",
            joinColumns = {@JoinColumn(name = "candidate_id", referencedColumnName = "id")},
            inverseJoinColumns = {@JoinColumn(name = "feedback_for_candidate_id", referencedColumnName = "id")})
    private List<FeedbackForCandidate> feedbacks;
}
