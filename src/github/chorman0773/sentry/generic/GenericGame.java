package github.chorman0773.sentry.generic;

import java.awt.Graphics;

import github.chorman0773.sentry.GameBasic;

public abstract class GenericGame extends GameBasic{
  private int frameRate;
  private int tickRate;
  private Thread graphicsInterruptThread;
  private Thread tickThread;
  private Thread renderThread;
  private boolean running;
  public GenericGame(int frameRate,int tickRate){
    frameRate = frameRate;
    tickRate = tickRate;
  }
  public void setFrameRate(int frameRate){
    this.frameRate = frameRate;
  }
  public void setTickRate(int tickRate){
    this.tickRate = tickRate;
  }
  public int getFrameRate(){
    return frameRate;
  }
  public int getTickRate(){
    return tickRate;
  }
  public abstract void tick();
  public abstract void render(Graphics g);
  
  private void renderLoop(){
    try{
      while(!Thread.interrupted()){
        Thread.sleep(1000/frameRate);
        renderThread.interrupt();
      }
    }catch(InterruptedException e){}
  }
  
  protected final void initGame()throws Exception{
    tickThread = new Thread(new Runnable(){
      public void run(){
        while(running){
          while(!Thread.interrupted());
          GenericGame.this.tick();
        }
      }
    });
    renderThread = new Thread(new Runnable(){
      public void run(){
        while(running){
          while(!Thread.interrupted());
          GenericGame.this.render(GenericGame.this.getGraphics());
        }
      }
    });
    graphicsInterruptThread = new Thread(this::renderLoop);
    doInit();
  }
  
  protected void doInit()throws Exception {}
  
  public final void run(){
    running = true;
    tickThread.start();
    renderThread.start();
    graphicsInterruptThread.start();
    try{
      while(!Thread.interrupted()){

        Thread.sleep(1000/tickRate);
        tickThread.interrupt();
      }
    }catch(InterruptedException e){}
    graphicsInterruptThread.interrupt();
  }
};
