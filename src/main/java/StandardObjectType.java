/**
 * Created by samujjal on 29/06/16.
 */
public enum StandardObjectType {
    Company("Company"),
    Relationship("Relationship"),
    RelationshipType("RelationshipType"),
    User("User");

    String objectType;
    StandardObjectType(String objectType) {
        this.objectType = objectType;
    }

    @Override
    public String toString() {
        return objectType;
    }

}
