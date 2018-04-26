package com.us.shipwreck.service;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import com.us.shipwreck.model.Shipwreck;

public class ShipwreckStub {
	
	private static Map<Long, Shipwreck> wrecks = new HashMap<Long, Shipwreck>();
	private static long idIndex = 3L;
	
	//populate initial wrecks
	static {
		Shipwreck a = new Shipwreck(1L, "U869", "A very deep German UBoat", "FAIR", 200, 44.12, 138.44, 1994);
		wrecks.put(1L, a);
			
		Shipwreck b = new Shipwreck(2L, "Thistlegorm", "British merchant boat in the Red Sea", "GOOD", 80, 44.12, 138.44, 1994);
		wrecks.put(2L, b);
			
		Shipwreck c = new Shipwreck(3L, "S.S. Yongala", "A luxury passenger ship wrecked on the great barrier reef", "FAIR", 50, 44.12, 138.44, 1994);
			wrecks.put(3L, c);
	}
	
	// GET /api/v1/shipwrecks (list)
	public static List<Shipwreck> list() {
		return new ArrayList<Shipwreck>(wrecks.values());
	}
	
	// POST /api/v1/shipwrecks (add)
	public static void create(Shipwreck wreck) {
		idIndex += idIndex;
		wreck.setId(idIndex);
		wrecks.put(idIndex, wreck);
		//return wreck;
	}
	
	// GET /api/v1/shipwrecks/{id} (view)
	public static Shipwreck get(Long id) {
		return wrecks.get(id);
	}
	
	// PUT /api/v1/shipwrecks/{id} (update)
	public static void update(Long id, Shipwreck wreck) {
		wrecks.put(id, wreck);
		//return wreck;
	}

	// DELETE /api/v1/shipwrecks/{id} (delete)
	public static void delete(Long id) {
		//return 
		wrecks.remove(id);
	}
	
	
}
