package backpropagation;

import java.io.File;
import java.io.IOException;
import java.util.ArrayList;

import interfaces.NeuralNetInterface;

public class NeuralNet implements NeuralNetInterface{

	int argNumInputs;
	int argNumHidden;
	int argNumOutputs;
	double argLearningRate;
	double argMomentumTerm;
	double argA;
	double argB;
	
	/**
	 * Constructor. (Cannot be declared in an interface, but your implementation will need one)
	 * @param argNumInputs The number of inputs in your input vector
	 * @param argNumHidden The number of hidden neurons in your hidden layer. Only a single hidden layer is supported
	 * @param argNumOutputs The number of outputs in the output vector 
	 * @param argLearningRate The learning rate coefficient
	 * @param argMomentumTerm The momentum coefficient
	 * @param argA Integer lower bound of sigmoid used by the output neuron only.
	 * @param arbB Integer upper bound of sigmoid used by the output neuron only.
	 * @param argUseBipolarHIddenNeurons boolean to use bipolar hidden neurons.
	 */
	public NeuralNet (
			int argNumInputs,
			int argNumHidden,
			int argNumOutputs,
			double argLearningRate,
			double argMomentumTerm,
			double argA,
			double argB,
			boolean argUseBipolarHIddenNeurons)
	{
		// store parameters	
		this.argNumInputs = argNumInputs;
		this.argNumHidden = argNumHidden;
		this.argNumOutputs = argNumOutputs;
		this.argLearningRate = argLearningRate;
		this.argMomentumTerm = argMomentumTerm;
		this.argA = argA;
		this.argB = argB;
		
		
		
	}
	
	/**
	 * Setup the input layer of the neural network
	 * @param argNumInputs The number of inputs in your input vector
	 * @return the input layer as an ArrayList of neurons
	 */
	public ArrayList<Neuron> setupInputLayer(int argNumInputs){
		ArrayList<Neuron> inputLayer = new ArrayList<>();
		for (int i = 0; i < argNumInputs; i++) {
            Neuron neuron = new Neuron(i+1);
            inputLayer.add(neuron);
        }
		return inputLayer;
	}
	
	/**
	 * Setup the hidden layers of the neural network (only 1 hidden layer in this Neural Net)
	 * @param argNumHidden The number of hidden neurons in your hidden layer. Only a single hidden layer is supported.
	 * @param inputLayer The input layer (ArrayList of input neurons) used to establish connections to the neurons in the hidden layer.
	 * @return the hidden layer as an ArrayList of neurons
	 */
	public ArrayList<Neuron> setupHiddenLayer(int argNumHidden, ArrayList<Neuron> inputLayer){
		ArrayList<Neuron> hiddenLayer = new ArrayList<>();
		Neuron biasNeuron = new Neuron(0);
		for (int i = 0; i < argNumHidden; i++) {
            Neuron neuron = new Neuron(101+i);
            neuron.addConnections(inputLayer);
            neuron.addBiasConnection(biasNeuron);
            hiddenLayer.add(neuron);
        }
		return hiddenLayer;
	}
	
	/**
	 * Setup the output layers of the neural network
	 * @param argNumOutputs The number of outputs in the output vector.
	 * @param hiddenLayer The hidden layer (ArrayList of hidden neurons) used to establish connections to the neurons in the output layer.
	 * @return the output layer as an ArrayList of neurons
	 */
	public ArrayList<Neuron> setupOutputLayer(int argNumOutputs, ArrayList<Neuron> hiddenLayer){
		ArrayList<Neuron> outputLayer = new ArrayList<>();
		Neuron biasNeuron = new Neuron(100);
		for (int i = 0; i < argNumOutputs; i++) {
            Neuron neuron = new Neuron(201+i);
            neuron.addConnections(hiddenLayer);
            neuron.addBiasConnection(biasNeuron);
            outputLayer.add(neuron);
        }
		return outputLayer;
	}
	
	
	@Override
	public double outputFor(double[] x) {
		// TODO Auto-generated method stub
		return 0;
	}

	@Override
	public double train(double[] x, double argValue) {
		// TODO Auto-generated method stub
		return 0;
	}

	@Override
	public void save(File argFile) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void load(String argFileName) throws IOException {
		// TODO Auto-generated method stub
		
	}

	@Override
	public double sigmoid(double x) {
		// TODO Auto-generated method stub
		return 0;
	}

	@Override
	public double customSigmoid(double x) {
		// TODO Auto-generated method stub
		return 0;
	}

	/**
	 * Initialize random weights
	 */
	@Override
	public void initializeWeights() {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void zeroWeights() {
		// TODO Auto-generated method stub
		
	}

}
