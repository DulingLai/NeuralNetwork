package test;

import static org.junit.Assert.*;

import java.util.ArrayList;

import org.junit.Test;
import org.junit.Before;
import org.junit.Test;

import backpropagation.Connection;
import backpropagation.NeuralNet;
import backpropagation.Neuron;

public class UnitTestNeuralNet {
	
	NeuralNet nn = new NeuralNet(
			2,	// int argNumInputs,
			4,	// int argNumHidden,
			1,  // int argNumOutputs,
			0.2,	// double argLearningRate,
			0.0, 	// double argMomentumTerm,
			0.0,	// double argA,
			1.0,	// double argB,
			false);	// boolean argUseBipolarHIddenNeurons);
	
	// Neuron to test neuron methods
	Neuron testNeuron = new Neuron(999);

	@Before
	public void setUp() throws Exception {
	}

	// Test the sigmoid methods
	@Test
	public void testBinarySigmoid() {
		double x = 1;
		double expectedResult = 0.731058;
		double delta = 0.001;
		double actualResult = testNeuron.binarySigmoid(x);
		assertEquals(expectedResult, actualResult, delta);	
	}

	@Test
	public void testBipolarSigmoid() {
		double x = 1;
		double expectedResult = 0.462117;
		double delta = 0.001;
		double actualResult = testNeuron.bipolarSigmoid(x);
		assertEquals(expectedResult, actualResult, delta);
	}
	
	// test the neural network layer setup methods
	@Test
	public void testSetupInputLayer(){
		int argNumInputs = 2;
		ArrayList<Neuron> actualInputLayer = nn.setupInputLayer(argNumInputs);
		int id_1 = actualInputLayer.get(0).getId();
		int id_2 = actualInputLayer.get(1).getId();
		assertEquals(1, id_1);
		assertEquals(2, id_2);
	}
	
	@Test
	public void testSetupHiddenLayer(){
		int argNumInputs = 2;
		int argNumHidden = 4;
		ArrayList<Neuron> actualInputLayer = nn.setupInputLayer(argNumInputs);
		ArrayList<Neuron> actualHiddenLayer = nn.setupHiddenLayer(argNumHidden,actualInputLayer);
		
		// test each neuron's id and its connection to the input neurons
		for (int i = 0; i < argNumHidden; i++){
			Neuron currentNeuron = actualHiddenLayer.get(i);
			// test id
			int id = currentNeuron.getId();
			assertEquals(101+i, id);

			// test connections
			ArrayList<Connection> currentConnections = currentNeuron.getAllInConnections();
			for (int j = 0; j < argNumInputs; j++){
				assertEquals(j+1, currentConnections.get(j).getFromNeuron().getId());
			}
		}
	}
	
	@Test
	public void testSetupOutputLayer(){
		int argNumInputs = 2;
		int argNumHidden = 4;
		int argNumOutput = 1;
		ArrayList<Neuron> actualInputLayer = nn.setupInputLayer(argNumInputs);
		ArrayList<Neuron> actualHiddenLayer = nn.setupHiddenLayer(argNumHidden,actualInputLayer);
		ArrayList<Neuron> actualOutputLayer = nn.setupOutputLayer(argNumOutput,actualHiddenLayer);
		
		// test each neuron's id and its connection to the input neurons
		for (int i = 0; i < argNumOutput; i++){
			Neuron currentNeuron = actualOutputLayer.get(i);
			// test id
			int id = currentNeuron.getId();
			assertEquals(201+i, id);

			// test connections
			ArrayList<Connection> currentConnections = currentNeuron.getAllInConnections();
			for (int j = 0; j < argNumHidden; j++){
				assertEquals(j+101, currentConnections.get(j).getFromNeuron().getId());
			}
		}
	}

}
