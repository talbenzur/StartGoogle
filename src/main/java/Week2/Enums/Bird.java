package Week2.Enums;


public enum Bird {
    TLEN("sterna hirundo") {
        @Override
        public void sing() {
            System.out.println("TLEN sing");
        }
    },
    STARLING("Sturnum Vulgaris") {
        @Override
        public void sing() {
            System.out.println("STARLING sing");
        }
    },
    TURKEY("Melegris gallopavo") {
        @Override
        public void sing() {
            System.out.println("TURKEY sing");
        }
    },
    SNIPE("Gallinago gallinago") {
        @Override
        public void sing() {
            System.out.println("SNIPE sing");
        }
    };

    Bird(String scientificName) {
        this.scientificName = scientificName;
    }

    public abstract void sing();

    public final String scientificName;
}
