import java.io.BufferedInputStream;
import java.io.DataInputStream;
import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

public class perpustakaanmain{
	public static void main(String[] args){
		File file = new File
("D:/praktikum5/perpustakaan.txt");
		FileInputStream fis = null;
		BufferedInputStream bis = null;
		DataInputStream dis = null;
		List<perpustakaan> listperpustakaan = new ArrayList
		<perpustakaan>();
		
		try{
			fis = new FileInputStream(file);
			bis = new BufferedInputStream(fis);
			dis = new DataInputStream(bis);
			
			while(dis.available() != 0){
			//memecah text perbaris menjadi beberapa kolom sesuai dengan pemisah koma
			String line = dis.readLine();
			String[] data = line.split(",");
			
			perpustakaan p = new perpustakaan();
			p.setId(data[0]);
			p.setPeminjam(data[1]);
			p.setJudul(data[2]);
			
			listperpustakaan.add(p);
		}
	} catch (IOException ex) {
		System.out.println("File " + file.getName() + "tidak ditemukan !");
		System.out.println("Exception : " + ex.getMessage());
		}
		
		for (perpustakaan perpus : listperpustakaan){
			System.out.println
		("======================================");
			System.out.println("ID : " + perpus.getId());
			System.out.println("Penyewa : " + perpus.getPeminjam());
			System.out.println("Judul : " + perpus.getJudul());
			}
		}
	}