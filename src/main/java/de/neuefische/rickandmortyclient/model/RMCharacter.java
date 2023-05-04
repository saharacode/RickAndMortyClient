package de.neuefische.rickandmortyclient.model;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class RMCharacter {
    private int id;
    private String name;
    private String species;
    private String status;
}
