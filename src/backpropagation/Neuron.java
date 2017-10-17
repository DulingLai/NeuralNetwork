package backpropagation;

import java.util.*;

public class Neuron {
	final int id; // id for neurons
	
	Connection biasConnection; // bias connection in the input and hidden layer
	final double bias = 1;
	
	private double output;  // output of the neuron
	
    ArrayList<Connection> inConnections = new ArrayList<Connection>();
    HashMap<Integer,Connection> connectionLookup = new HashMap<Integer,Connection>();
	
	public Neuron(int i){
		id = i;
	}
	
	/**
	 * Sigmoid functions (binary and bipolar)
	 * @param x The input to the sigmoid function
	 * @return The output signal of the sigmoid function
	 */
	public double binarySigmoid(double x){
		// compute the output signal of the binary sigmoid function with input x
		return 1/(1 + Math.exp(-x));
	}
	public double bipolarSigmoid(double x){
		// compute the output signal of the bipolar sigmoid function with input x
		return 2/(1 + Math.exp(-x))-1;
	}
	
	/**
	 * calculating the output for the Neurons (binary/bipolar)
	 * @param argUseBipolarHIddenNeurons boolean to use bipolar hidden neurons.
	 * @return The output signal of the neuron.
	 */
	public void calculateOutput(boolean argUseBipolarHIddenNeurons){
	    /*
	     * Compute Sj = Wij*Xij + w0j*bias
	     */
		double s = 0;
        for (Connection con : inConnections) {
            Neuron leftNeuron = con.getFromNeuron();
            double weight = con.getWeight();
            double x = leftNeuron.getOutput(); // output from the previous layer
            s += weight * x;
        }
        s += biasConnection.getWeight()*bias; // add the bias
        if (argUseBipolarHIddenNeurons){
        	output = binarySigmoid(s); // compute the output (binary)
        } else {
        	output = binarySigmoid(s); // compute the output (bipolar)
        }
	}
	
	/*
	 * Getter and setter for the output
	 */
	public double getOutput(){
		return output;
	}
	public void setOutput(double o){
		output = o;
	}
	
	public double getBias(){
		return bias;
	}
	
	public int getId(){
		return id;
	}
	
	/*
	 * Functions to deal with the connections (add/get)
	 */
	/**
	 * add connections given an array of neurons.
	 * @param ArrayList<Neuron> neurons The array list of neurons to add connections to the current neuron.
	 */
    public void addConnections(ArrayList<Neuron> neurons) {
        for (Neuron n : neurons) {
            Connection con = new Connection(n, this);
            inConnections.add(con);
            connectionLookup.put(n.id, con);
        }
    }
    
    public void addConnections(Neuron[] neurons) {
        for (Neuron n : neurons) {
            Connection con = new Connection(n,this);
            inConnections.add(con);
            connectionLookup.put(n.id, con);
        }
    }
    
	/**
	 * add connection to our connection array list.
	 * @param Con The connection to be added to the connections array list.
	 */
    public void addInConnection(Connection con){
        inConnections.add(con);
    }
 
	/**
	 * add bias connection to the current neuron.
	 * @param n The bias neuron to be connected to the current neuron.
	 */
    public void addBiasConnection(Neuron n){
        Connection con = new Connection(n,this);
        biasConnection = con;
        inConnections.add(con);
    }
	
    // Getter for all the connections
    public ArrayList<Connection> getAllInConnections(){
        return inConnections;
    }
	
}
