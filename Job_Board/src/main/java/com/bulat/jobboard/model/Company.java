package com.bulat.jobboard.model;

import com.bulat.jobboard.service.GettersForCommonFieldsThatAreSearched;
import lombok.*;

import javax.persistence.*;
import java.util.List;

/**
 * Class responsible for the entity of the company
 * @author Bulat Bilalov
 * @version 1.0
 * @see com.bulat.jobboard.model.BaseEntity
 * @see com.bulat.jobboard.service.GettersForCommonFieldsThatAreSearched
 * @see db.changelog/db.changelog-1.4.xml
 */
@EqualsAndHashCode(callSuper = false)
@Data
@NoArgsConstructor
@AllArgsConstructor
@Builder
@Entity
@Table(name = "vacancy_company")
public class Company extends BaseEntity implements GettersForCommonFieldsThatAreSearched {

    /** Company name */
    @Column(name = "name")
    private String name;

    /** Required age */
    @Column(name = "age")
    private String age;

    /** Type of work*/
    @Column(name = "job_nature")
    @Enumerated(EnumType.STRING)
    private JobNature jobNature;

    /** Link to profile picture */
    @Column(name = "link_img")
    private String link_img;

    /** Country of location of the company */
    @ManyToOne(fetch = FetchType.EAGER)
    @JoinColumn(name="country_id")
    private Country country;

    /** City of location of the company */
    @ManyToOne(fetch = FetchType.EAGER)
    @JoinColumn(name="city_id")
    private City city;

    /** Language proficiency programming */
    @ManyToOne(fetch = FetchType.EAGER)
    @JoinColumn(name="skill_id")
    private Skill skill;

    /** Salary per year */
    @Column(name = "salary")
    private String salary;

    /** Work experience (number of years) */
    @Column(name = "experience")
    @Enumerated(EnumType.STRING)
    private Experience experience;

    /** Work description */
    @Column(name = "description", length = 3000)
    private String description;

    /** Desired gender */
    @Column(name = "gender")
    @Enumerated(EnumType.STRING)
    private Gender gender;

    /** Contact information (mail) */
    @Column(name = "contact")
    private String contact;

    /** Link to the unique identifier of the registered user */
    @Column(name = "user_id")
    private Long userId;
}
