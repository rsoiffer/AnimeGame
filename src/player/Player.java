package player;

import core.AbstractEntity;
import core.Color4d;
import core.Vec3;
import graphics.ModelComponent;
import graphics.ModelSystem;
import movement.*;

public class Player extends AbstractEntity {

    public Player(Vec3 pos) {
        //Components
        PositionComponent pc = add(new PositionComponent(pos));
        VelocityComponent vc = add(new VelocityComponent());
        RotationComponent rc = add(new RotationComponent());
        PreviousPositionComponent ppc = add(new PreviousPositionComponent(pos));
        GravityComponent gc = add(new GravityComponent());
        ModelComponent mc = add(new ModelComponent(.2, new Color4d(.2, .4, 1), "player_actionpose"));
        CollisionComponent cc = add(new CollisionComponent(pc, 1, .5, false));
        //Systems
        add(new PlayerControlSystem(pc, vc, rc, cc));
        add(new VelocitySystem(pc, vc));
        add(new GravitySystem(vc, gc));
        add(new CollisionSystem(pc, vc, ppc, cc));
        add(new CameraSystem(pc));
        add(new ModelSystem(pc, rc, mc));
        add(new PreviousPositionSystem(pc, ppc));
    }
}
