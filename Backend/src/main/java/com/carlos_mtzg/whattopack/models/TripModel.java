package com.carlos_mtzg.whattopack.models;

import java.sql.Date;
import java.sql.Timestamp;
import java.util.List;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.OneToMany;
import jakarta.persistence.Table;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@Entity
@Table(name = "trip")
public class TripModel {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;
    private String city;
    private Date startDate;
    private Date endDate;
    private String tripType;
    private String travelerType;
    private Timestamp createdAt;

    @OneToMany(mappedBy = "trip")
    private List<WeatherModel> weatherList;

    @OneToMany(mappedBy = "trip")
    private List<UserSelectionModel> userSelectionList;

    @OneToMany(mappedBy = "trip")
    private List<RecomendationItemModel> recomendationItemList;
}
