package at.dropical.shared.example.kempsImpl.serverside;

public class KempsUser {
    private Object metadata;
    private KempsToClientMagic toClientMagic;

    public KempsUser(KempsToClientMagic toClientMagic) {
        this.toClientMagic = toClientMagic;
    }
}
