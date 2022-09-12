# Hashmap-Image-Search

This program uses a hashmap to allow users to search a list of images for the images that contain certain elements, such as buildings, people, animals, etc. 

The program first reads a text file with a list of images in the format "image_name.png element1 element2". I've included an example of such a file in this repository called "image_info.txt". The name of each image is read into the hashmap as a key, and the following elements in the line are the key's corresponding values. 

Once the key/value sets are successfully read, the user can enter a search in the form "buildings", or the following forms for multiple elements: "buildings and people", "people or animals". If the search phrase includes "and", a list of images containing both elements will be in the output window. If the search contains "or", images that contain either element will be listed in the output window.
