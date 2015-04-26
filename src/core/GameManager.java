package core;

import graphics.RenderManagerComponent;
import graphics.RenderManagerSystem;
import graphics.SunComponent;
import level.LevelComponent;
import level.LevelSystem;

public class GameManager extends AbstractEntity {

    public RenderManagerComponent rmc;
    public EntityListComponent elc;

    public GameManager() {
        rmc = add(new RenderManagerComponent());
        add(new RenderManagerSystem(rmc));

        add(new SunComponent());

        FPSManagerComponent fmc = add(new FPSManagerComponent());
        add(new FPSManagerSystem(fmc));

        elc = add(new EntityListComponent());

        LevelComponent lc = add(new LevelComponent(30));
        add(new LevelSystem(lc));
    }
}
