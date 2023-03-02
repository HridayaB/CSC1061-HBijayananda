package edu.frcc.csc1061j.PlaylistManager;

import java.util.LinkedList;
import edu.frcc.csc1061j.ArrayAndLinkedLists.MyDoubleLinkedList;


public class TestSong {

	public static void main(String[] args) {
		Song song = new Song("Kanye West", "Hurricane");
		LinkedList <Song> songList = new LinkedList<>();
		songList.add(song);
		System.out.println(songList);
		MyDoubleLinkedList <Song> songl = new MyDoubleLinkedList<>();
		//System.out.println(song.toString());
	}

}
