package fr.vt.model;

import java.util.List;

import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.NoArgsConstructor;
import lombok.experimental.SuperBuilder;

@Data
@EqualsAndHashCode(callSuper = false)
@SuperBuilder
@NoArgsConstructor
public abstract class Activity extends Resource {
    
    public abstract Location getLocation();

    public abstract Personnel getTeacher();

    public abstract List<Group> getGroups();
}
