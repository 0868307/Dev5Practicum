package daos;

import org.neo4j.graphdb.RelationshipType;

/**
 * Created by darryl on 6-11-14.
 */
public enum RelTypes implements RelationshipType{
    WORN_BY;
    public static final String FROM = "from";
}
