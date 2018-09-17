package com.vishalgarg;

import java.util.Map.Entry;
import java.util.TreeMap;


public class ZipRangeExlusion {
	
	public static void main(String[] args) {
		
	try {
		
		ZipRange[] z = new ZipRange[10];
		z[0] = new ZipRange(94133,94133);
		z[1] = new ZipRange(94200,94299);
		z[2] = new ZipRange(94226,94399);
		z[3] = new ZipRange(3,4);
		z[4] = new ZipRange(5,10); 
		z[5] = new ZipRange(6,8);
		z[6] = new ZipRange(9,12);
		z[7] = new ZipRange(14,18);
		z[8] = new ZipRange(18,18);
		z[9] = new ZipRange(20,20); 
		
		TreeMap<Integer, Integer> tmap = new TreeMap<Integer, Integer>();
		
		/*	Logic to Exclude any ZipRanges which start with same lower value
		 * 	and add all the zip ranges to a sorted hash map.
		 * 
		 */
		for (ZipRange i : z) {
			if (tmap.get(i.getLower()) == null) {
				tmap.put(i.getLower(), i.getUpper());
			} else {
				tmap.put(i.getLower(), Math.max(tmap.get(i.getLower()), i.getUpper()));
			}
		}

		System.out.println("Initial Set" + tmap);
		
		// Map for Storing the end result
		TreeMap<Integer, Integer> tmap1 = new TreeMap<Integer, Integer>();
		
		
		//Logic to provide the minimal number of Ranges
		for (Entry<Integer, Integer> entry : tmap.entrySet()) {
			if (tmap1.size() == 0) {
				tmap1.put(entry.getKey(), entry.getValue());
				continue;				
			} else if (tmap1.size() != 0) {
				if ((entry.getKey() == (tmap1.get(tmap1.lastKey()) + 1)
						|| entry.getKey() == (tmap1.get(tmap1.lastKey())))) {
					tmap1.put(tmap1.lastKey(), entry.getValue());
					continue;
				} else if ((entry.getKey() > tmap1.lastKey())
						&& (entry.getValue() < (tmap1.get(tmap1.lastKey())))) {
					continue;
				} else if (entry.getKey() > (tmap1.get(tmap1.lastKey())) ) {
					tmap1.put(entry.getKey(), entry.getValue());
					continue;
				} else if ((entry.getKey() > tmap1.lastKey())
						&& (entry.getValue() > (tmap1.get(tmap1.lastKey())))) {
					tmap1.put(tmap1.lastKey(), entry.getValue());
					continue;
				}

			}
		}
		System.out.print("Final Set : ");
		for (Entry<Integer, Integer> entry : tmap1.entrySet()) {
			System.out.print("{" + entry.getKey() + "," + entry.getValue() + "}");
		}
	}catch (Exception e){
		System.out.println(e.getStackTrace());
	}
	}

}
