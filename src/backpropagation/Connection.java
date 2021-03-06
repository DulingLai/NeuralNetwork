package backpropagation;

public class Connection {
    private double weight = 0;
    private double bestWeight = 0;
    private double prevDeltaWeight = 0; // for momentum
    private double deltaWeight = 0;

    final Neuron leftNeuron;
    final Neuron rightNeuron;
    static int counter = 0;
    final int id; // auto increment, starts at 0

    Connection(Neuron fromN, Neuron toN) {
        leftNeuron = fromN;
        rightNeuron = toN;
        id = counter;
        counter++;
    }

    double getWeight() {
        return weight;
    }

    void setWeight(double w) {
        weight = w;
    }

    void setBestWeight(double w) {
        bestWeight = w;
    }

    void setWeightAsBest() {
        weight = bestWeight;
    }

    void setDeltaWeight(double w) {
        prevDeltaWeight = deltaWeight;
        deltaWeight = w;
    }

    double getPrevDeltaWeight() {
        return prevDeltaWeight;
    }

    public Neuron getFromNeuron() {
        return leftNeuron;
    }
    
    public Neuron getToNeuron(){
    	return rightNeuron;
    }
}
