package de.neuefische.rickandmortyclient.model;


import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.List;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class RMCharacterCollection {
    //private RMInfo info; // this class is not necessary to get characters
    private List<RMCharacter> results; // name has to be the same like in json (see documentary)
}
