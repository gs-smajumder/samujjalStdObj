/**
 * Created by apple on 28/06/16.
 */
public class Version implements Comparable {
    int majorVersion;
    int minorVersion;

    public Version(String version){
        String[] verses = version.split("\\.");
        if(verses.length != 2){
            throw new IllegalArgumentException("Version string invalid. Should be in X.Y string form for Major X and Minor Y");
        }
        majorVersion = Integer.parseInt(verses[0]);
        minorVersion = Integer.parseInt(verses[1]);

    }

    @Override
    public String toString() {
        return "Version{" +
                "majorVersion=" + majorVersion +
                ", minorVersion=" + minorVersion +
                '}';
    }

    public int getMajorVersion() {
        return majorVersion;
    }

    public int getMinorVersion() {
        return minorVersion;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        Version version = (Version) o;

        if (getMajorVersion() != version.getMajorVersion()) return false;
        return getMinorVersion() == version.getMinorVersion();

    }

    @Override
    public int hashCode() {
        int result = getMajorVersion();
        result = 31 * result + getMinorVersion();
        return result;
    }

    public int compareTo(Object o) {
        Version toVersion = (Version)o;
        if(this.majorVersion == toVersion.majorVersion && this.minorVersion == toVersion.minorVersion){
            return 0;
        }
        if(this.majorVersion > toVersion.majorVersion){
            return 1;
        }else{
            if(this.majorVersion == toVersion.majorVersion && this.minorVersion > toVersion.minorVersion){
                return 1;
            }
        }
        return -1;
    }
}
