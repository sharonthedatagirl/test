// IPPO Assignment 1, Version 20.3, 14/10/2020
package ippo.assignment1.controller;

import ippo.assignment1.library.Picture;
import ippo.assignment1.library.controller.Controller;
import ippo.assignment1.library.service.Service;
import ippo.assignment1.library.service.ServiceFromProperties;
import ippo.assignment1.library.view.View;
import ippo.assignment1.library.view.ViewFromProperties;
import ippo.assignment1.library.utils.HashMap;



/**
 * A HashMap controller for the PictureViewer application.
 * 
 * @author Paul Anderson &lt;dcspaul@ed.ac.uk&gt;
 * @version 20.3, 14/10/2020
 */
public class HashMapController implements Controller {

	private View view;
	private Service service;
	private HashMap<Integer, Picture> hashmap;
	/**
	 * Start the controller.
	 */
	public void start() {
		// create the view and the service objects
		view = new ViewFromProperties(this);
		service = new ServiceFromProperties();
		hashmap = new HashMap<>();

		// populating the hashmap with selection as key and picture as value
		hashmap.put(view.addSelection("Stob Binnein"), service.getPicture("Stob Binnein",1));
		hashmap.put(view.addSelection("Gairich"), service.getPicture("Gairich",1));
		hashmap.put(view.addSelection("Ben Lomond"), service.getPicture("Ben Lomond",1));
		hashmap.put(view.addSelection("Meall Buidhe"), service.getPicture("Meall Buidhe",1));


		// start the interface
		view.start();
	}

	/**
	 * Handle the specified selection from the interface.
	 *
	 * @param selectionID the id of the selected item
	 */
	public void select(int selectionID) {
		// get a picture corresponding to the selectionID
		Picture picture = hashmap.get(selectionID);

		// show the picture in the interface
		view.showPicture(picture);
	}
}
