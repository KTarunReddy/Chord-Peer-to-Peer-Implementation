import akka.actor.Actor

/**
 * @author TARUN
 */
class Node (nodeId: Int, nodeName: String, numRequests: Int) extends Actor {
  
  def receive = {
    
    case Messages.join(randNode: Int) => {

      if (randNode == -1) {
        successor = hashName;
        predecessor = hashName;
        fillFingerTable(-1);
        isJoined = true              
        ChordSimulator.numNodesJoined = ChordSimulator.numNodesJoined + 1;        
      } else {
        var tempActor = context.actorSelection(prefix + randNode)
        tempActor ! Messages.findPredecessor(hashName, hashName, setRequest, null)
      }
    }
    
  }
  
}