/**
 * Created by apple on 29/06/16.
 */
public abstract class UpgradeHandlerBase implements UpgradeHandler {
    private Version souceVersion;
    private Version targetVersion;
    private StandardObjectType standardObjectType;

    public Version getSourceVersion(){
        return souceVersion;
    }
    public Version getTargetVersion(){
        return targetVersion;
    }

    public StandardObjectType getStandardObjectType() {
        return standardObjectType;
    }

    protected void setSouceVersion(Version souceVersion) {
        this.souceVersion = souceVersion;
    }

    protected void setTargetVersion(Version targetVersion) {
        this.targetVersion = targetVersion;
    }

    protected void setStandardObjectType(StandardObjectType standardObjectType) {
        this.standardObjectType = standardObjectType;
    }

    public boolean canUpgrade(String tenantId) {
        //verify tenant schema version is same as sourceVersion if needed
        return targetVersion.compareTo(souceVersion) == 1;
    }

    public void upgrade(String tenantId) {
        //TODO: Fetch tenant schema and perform Mongo/RedShift db operations

        System.out.println(String.format("Upgrading tenant %s from %s to %s", tenantId, getSourceVersion().toString(), getTargetVersion().toString()));
    }

    public void rollback(String tenantId) {
        throw new UnsupportedOperationException("Version RollBack not supported");

    }
}
