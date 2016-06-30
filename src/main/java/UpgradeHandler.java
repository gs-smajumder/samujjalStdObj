/**
 * Created by apple on 28/06/16.
 */
public interface UpgradeHandler {
    boolean canUpgrade(String tenantId);
    void upgrade(String tenantId);
    void rollback(String tenantId);
}
