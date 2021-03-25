import java.util.Scanner;
import java.util.Stack;
import model.Playlist;

public class Main {

    static Stack<Playlist> playlists = new Stack();

    public static void main(String[] args) {
        int prompt = 1;
        Scanner scan = new Scanner(System.in);

        // seeder
        playlists.push(new Playlist("Hello world", "world"));
        playlists.push(new Playlist("Clouds", "NF"));
        playlists.push(new Playlist("Amazing", "Tofik"));
        // end seeder

        while(prompt > 0 && prompt < 5) {
            System.out.println("===== Daftar Menu =====");
            System.out.println("1. Tampilkan Data Playlist");
            System.out.println("2. Tambah Data Playlist");
            System.out.println("3. Hapus Data Playlist");
            System.out.println("4. Hapus semua Playlist");

            System.out.print("Masukan nomor menu : ");

            try {
                prompt = Integer.parseInt(scan.nextLine());
            } catch(NumberFormatException e) {
                prompt = -1;
            }

            // logical block
            switch (prompt) {
                case 1 :
                    viewPlaylist();
                    break;  
                case 2:
                    addPlaylist(scan);
                    break;
                case 3:
                    deletePlaylist(scan);
                    break;
                case 4:
                    deleteAllPlaylist();
                    break;
            }
        }
        scan.close();
        System.out.println("===== Program Berakhir =====");
    }

    // view all playlist
    static void viewPlaylist() {
        System.out.println("===== Daftar Playlist =====");
        for(int i = 0; i < playlists.size(); i++) {
            Playlist currentPlaylist = playlists.get(i);
            System.out.println("ID    : " + i);
            System.out.println("Title : " + currentPlaylist.title);
            System.out.println("Owner : " + currentPlaylist.owner);
            System.out.println("---------------------");
        }
    }

    // add playlist
    static void addPlaylist(Scanner scan) {
        String title = "";
        String owner = "";
        int index = -1;
        System.out.println("===== Input Playlist =====");
        System.out.print("Masukan judul        : ");
        title = scan.nextLine();
        System.out.print("Masukan Pemilik      : ");
        owner = scan.nextLine();
        System.out.print("Masukan Index [skip] : ");

        try {
            index = Integer.parseInt(scan.nextLine());
        } catch(NumberFormatException e) {
            // empty
        }

        if(index >= 0) {
            playlists.add(index, new Playlist(title, owner));
        } else {
            playlists.push(new Playlist(title, owner));
        }
    }

    // delete
    static void deletePlaylist(Scanner scan) {
        int index = -1;
        System.out.println("===== Input Playlist =====");
        System.out.print("Masukan Index [skip] : ");
        try {
            index = Integer.parseInt(scan.nextLine());
        } catch(NumberFormatException e) {
            // empty
        }
        if(index >= 0) {
            playlists.remove(index);
        } else {
            playlists.remove(0);
        }
    }

    // delete all
    static void deleteAllPlaylist() {
        System.out.println("===== Menghapus semua playlist =====");
        playlists.clear();
    }


}
