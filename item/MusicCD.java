public class MusicCD extends Item{
    private String singer;
    private String[] tracks;

    public MusicCD(String name, int price, boolean inStock, String singer, String tracklist){
        super(name, price, "MusicCD", inStock);
        this.singer = singer;
        this.tracks = MusicTracks.getTracks(tracklist);
    }
    @Override
    public String getDescription(){
        // MusicCD 클래스의 정보 추가
        return String.format("Singer: %s\nTrack List:\n\t%s\n",
                singer, String.join(",\t", tracks));
    }
}
