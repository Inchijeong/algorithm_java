package programmers.kit.hash.q4_best_album;

import java.util.ArrayList;
import java.util.Comparator;
import java.util.HashMap;
import java.util.List;

public class BestAalbum {
	public static void main(String[] args) {
		String[] genres = {"classic", "pop", "classic", "classic", "pop"};
		int[] plays = {500, 600, 150, 800, 2500};
		
		solution(genres, plays);
	}
	
    public static int[] solution(String[] genres, int[] plays) {
        int len = genres.length;
        
        HashMap<String, Integer> totalPlays = new HashMap<String, Integer>();
        List<Song> songList = new ArrayList<Song>();
        
        for(int i = 0; i < len; i++){
        	
        	String genre = genres[i];
        	int play = plays[i];
        	
        	Song song = new Song(i, genre, play){};
        	songList.add(song);
        	
        	int totalPlay = 0;
        	
            // �̹� �����ϴ� �帣���
            if(totalPlays.containsKey(genres[i])){
            	totalPlay = totalPlays.get(genre) + play;
            }else{ // �ű� �帣
            	totalPlay = play;
            }
            totalPlays.put(genre, totalPlay);
        }
        
        // �帣�� �� ����� �־��ֱ�
        for(int i = 0; i < songList.size(); i++){
        	Song song = songList.get(i);
        	song.totalPlay = totalPlays.get(song.genre);
        }
        
        // ����� ��������
        Comparator<Song> playReverse = Comparator.comparing(Song::getPlay).reversed();
        
        // �� ����� ��������, ����� ��������, �ε��� ������������ ����
        songList.sort(Comparator
        		.comparing(Song::getTotalPlay).reversed() // ù comparing ���������� .reversed() �� ����Ѵ�.
        		.thenComparing(playReverse)
        		.thenComparing(Song::getIdx));
        
        String preGenre = songList.get(0).getGenre();
        int songCnt = 0;
        List<Integer> idxList = new ArrayList<Integer>();
        
        for(int i = 0; i < songList.size(); i++){
        	Song song = songList.get(i);
        	
//        	System.out.print(song.idx);
//        	System.out.print(" ");
//        	System.out.print(song.genre);     	
//        	System.out.print(" ");
//        	System.out.print(song.play);     	
//        	System.out.print(" ");
//        	System.out.print(song.totalPlay);
        	
        	// ���� ��� ���� �帣�� ���
        	if(preGenre.equals(song.getGenre())) {
        		if(songCnt < 2) {
        			idxList.add(song.getIdx());
        			songCnt++;
        		}
        	}else { // ���� ��� �ٸ� �帣�� ���
        		idxList.add(song.getIdx());
        		preGenre = song.getGenre();
        		songCnt = 1;
        	}
        	
//        	System.out.print(" ");
//        	System.out.println(songCnt);
        }
        
        int idxListSize = idxList.size();
        int[] answer = new int[idxListSize];
        
        for(int i = 0; i < idxListSize; i++){
//        	System.out.println(idxList.get(i));
        	answer[i] = idxList.get(i);
        }
        
        return answer;
    }
}

class Song{
	int idx;
	String genre;
	int play;
	int totalPlay;
	
	public int getIdx() {
		return idx;
	}
	public void setIdx(int idx) {
		this.idx = idx;
	}
	public String getGenre() {
		return genre;
	}
	public void setGenre(String genre) {
		this.genre = genre;
	}
	public int getPlay() {
		return play;
	}
	public void setPlay(int play) {
		this.play = play;
	}
	public int getTotalPlay() {
		return totalPlay;
	}
	public void setTotalPlay(int totalPlay) {
		this.totalPlay = totalPlay;
	}
	
	Song(){
		this.setTotalPlay(0);
	}
	Song(int idx, String genre, int play){
		this.setIdx(idx);
		this.setGenre(genre);
		this.setPlay(play);
		this.setTotalPlay(0);
	}
}