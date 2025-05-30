package com.carlos_mtzg.whattopack.models;

import java.util.List;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
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
@Table(name = "recomendation_item")
public class RecomendationItemModel {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;
    private String name;
    private String weatherType;
    private Boolean isCustom;

    @ManyToOne
    @JoinColumn(name = "trip_id", nullable = true)
    private TripModel trip;

    @ManyToOne
    @JoinColumn(name = "section_id")
    private SectionModel section;

    @OneToMany(mappedBy = "recomendationItem")
    private List<UserSelectionModel> userSelectionList;
}
