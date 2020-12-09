package guru.springframework.msscbeerservice.domain;

import lombok.*;
import org.hibernate.annotations.CreationTimestamp;
import org.hibernate.annotations.GenericGenerator;
import org.hibernate.annotations.Type;
import org.hibernate.annotations.UpdateTimestamp;

import javax.persistence.*;
import java.math.BigDecimal;
import java.sql.Timestamp;
import java.util.UUID;

/**
 * Created by jt on 2019-05-17.
 */
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@Builder
@Entity
public class Beer {
    // columnDefinition = "varchar(36)" we put "varchar(36)" as in MySql getting error while saving UUID

    @Id
    @GeneratedValue(generator = "UUID")
    @GenericGenerator(name = "UUID", strategy = "org.hibernate.id.UUIDGenerator")
    @Type(type="org.hibernate.type.UUIDCharType")
    @Column(length = 36, columnDefinition = "varchar(36)", updatable = false, nullable = false)
    private UUID id;

    @Version
    private Long version;

    @CreationTimestamp           // this Timestamp is created by hibernate and take the current timestamp
    @Column(updatable = false)
    private Timestamp createdDate;

    @UpdateTimestamp             // this is like a normal value that we can update with SQL Update statement
    private Timestamp lastModifiedDate;

    private String beerName;
    private String beerStyle;


    private String upc;

    private BigDecimal price;

    private Integer minOnHand;
    private Integer quantityToBrew;


}

/*
(1)
https://www.baeldung.com/hibernate-identifiers

@GenericGenerator()  <--- we can define a strategy, that how hibernate should generate a id

e.g
-----

@Entity
	public class User {
	    @Id
	    @GeneratedValue(generator = "sequence-generator")
	    @GenericGenerator(
	      name = "sequence-generator",
	      strategy = "org.hibernate.id.enhanced.SequenceStyleGenerator",
	      parameters = {
	        @Parameter(name = "sequence_name", value = "user_sequence"),
	        @Parameter(name = "initial_value", value = "4"),
	        @Parameter(name = "increment_size", value = "1")
	        }
	    )

(2)
@Version
--------
UPDATE MyEntity SET ..., VERSION = VERSION + 1 WHERE ((ID = ?) AND (VERSION = ?))

Version used to ensure that only one update in a time. JPA provider will check the version,
if the expected version already increase then someone else already update the entity so an
exception will be thrown.
So updating entity value would be more secure, more optimist.
If the value changes frequent, then you might consider not to use version field.
For an example "an entity that has counter field, that will increased everytime
a web page accessed"

 */
