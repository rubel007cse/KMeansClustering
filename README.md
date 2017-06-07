# KMeansClustering
## Mosharrof Rubel (rubel007cse@gmail.com)
It is a type of unsupervised algorithm which  solves the clustering problem.
Its procedure follows a simple and easy  way to classify a given data set through a certain number of
clusters (assume k clusters).
Data points inside a cluster are homogeneous and heterogeneous to peer groups.
Remember figuring out shapes from ink blots? k means is somewhat similar this activity.
You look at the shape and spread to decipher how many different clusters / population are present!

### How K-means forms cluster:

    K-means picks k number of points for each cluster known as centroids.
    Each data point forms a cluster with the closest centroids i.e. k clusters.
    Finds the centroid of each cluster based on existing cluster members. Here we have new centroids.
    As we have new centroids, repeat step 2 and 3. Find the closest distance for each data point from new centroids and get associated with new k-clusters. Repeat this process until convergence occurs i.e. centroids does not change.

(Source: analyticsvidhya)