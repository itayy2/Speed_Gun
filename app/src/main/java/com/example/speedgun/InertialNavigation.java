package com.example.speedgun;

public class InertialNavigation {


    public float x;
    private float y;
    private float z;

    private float vx;
    private float vy;
    private float vz;

    private float ax;
    private float ay;
    private float az;

    private float gx;
    private float gy;
    private float gz;

    private float theta;
    private float phi;
    private float alpha;

    private float m;

    private float tAx = 0;
    private float dtAx; // |Make it public|

    private float tGx = 0;
    private float dtGx;

    private float Rtranfer = (float) 1/1000;


    public InertialNavigation(float x, float y, float z, float vx, float vy, float vz, float theta, float phi, float alpha, float dtAx, float dtGx) {
        this.x = x;
        this.y = y;
        this.z = z;
        this.vx = vx;
        this.vy = vy;
        this.vz = vz;
        this.theta = theta;
        this.phi = phi;
        this.alpha = alpha;
        this.dtAx = dtAx;
        this.dtGx = dtGx;
    }

    public void SetChangeAcceleration(float ax, float ay, float az){


        this.tAx = tAx + (1/dtAx);

        this.vx = (float) ( vx + (((ax + this.ax)/2) - 0) * (1/dtAx) * Rtranfer) ;      // | We needs to set a v0x = 0 at the start only |
        this.vy = (float) ( vy + ((ay - 0) * (1/dtAx) * Rtranfer) );      // | We needs to set a v0y = 0 at the start only |
        this.vz = (float) ( vz + ((az - 9.9) * (1/dtAx) * Rtranfer) );      // | We needs to set a v0z = 0 at the start only |


        this.x = (float) ( x + this.vx * (1/dtAx) * Rtranfer + 0.5 * (ax - 0) * (1/dtAx) * (1/dtAx) * Rtranfer * Rtranfer );     // | We needs to set a x0 = 0 at the start only |
        this.y = (float) ( y + this.vy * (1/dtAx) * Rtranfer + 0.5 * (ay - 0) * (1/dtAx) * (1/dtAx) * Rtranfer * Rtranfer);     // | We needs to set a y0 = 0 at the start only |
        this.z = (float) ( z + this.vz * (1/dtAx) * Rtranfer + 0.5 * (az - 9.9) * (1/dtAx) * (1/dtAx) * Rtranfer * Rtranfer);     // | We needs to set a z0 = 0 at the start only |

        // לקרוא על אנליזה נומרית

        this.ax = ax;
        this.ay = ay;
        this.az = az;
        // |All the zeros are needs to be some values from the calibration |


        // |All the zeros are needs to be some values from the calibration |

    }

    public void SetChangeGyro(float gx, float gy, float gz){
        this.gx = gx;
        this.gy = gy;
        this.gz = gz;


        this.tGx = tGx + (1/dtGx);

        // |All the zeros are needs to be some values from the calibration |


        this.theta = (float) ( theta + ((gz - 0) * (1/dtGx) * Rtranfer) );
        this.phi = (float) ( phi + ((gy - 0) * (1/dtGx) * Rtranfer) );
        this.alpha = (float) ( alpha + ((gx - 0) * (1/dtGx) * Rtranfer) );

        // |All the zeros are needs to be some values from the calibration |

    }

    public void setTheta(float theta) {
        this.theta = theta;
    }

    public void setPhi(float phi) {
        this.phi = phi;
    }

    public void setAlpha(float alpha) {
        this.alpha = alpha;
    }

    public void setX(float x) {
        this.x = x;
    }

    public void setY(float y) {
        this.y = y;
    }

    public void setZ(float z) {
        this.z = z;
    }

    public void setVx(float vx) {
        this.vx = vx;
    }

    public void setVy(float vy) {
        this.vy = vy;
    }

    public void setVz(float vz) {
        this.vz = vz;
    }
}
