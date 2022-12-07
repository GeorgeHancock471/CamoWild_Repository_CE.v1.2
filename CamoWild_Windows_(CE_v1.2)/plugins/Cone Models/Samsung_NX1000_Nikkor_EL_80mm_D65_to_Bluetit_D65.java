// Code automatically generated by 'Generate Cone Mapping Model' script by Jolyon Troscianko

//Model fits:
//lw 0.9983021427709174
//mw 0.9994705814059762
//sw 0.9996812035128247
//uv 0.9988321586352321
//dbl 0.9997683316935281


// Generated: 2019/2/12   15:47:47


import ij.*;
import ij.plugin.filter.PlugInFilter;
import ij.process.*;

public class Samsung_NX1000_Nikkor_EL_80mm_D65_to_Bluetit_D65 implements PlugInFilter {

ImageStack stack;
	public int setup(String arg, ImagePlus imp) { 
	stack = imp.getStack(); 
	return DOES_32 + STACK_REQUIRED; 
	}
public void run(ImageProcessor ip) {

IJ.showStatus("Cone Mapping");
float[] vR;
float[] vG;
float[] vB;
float[] uB;
float[] uR;
int w = stack.getWidth();
int h = stack.getHeight();
int dimension = w*h;

float[] lw = new float[dimension];
float[] mw = new float[dimension];
float[] sw = new float[dimension];
float[] uv = new float[dimension];
float[] dbl = new float[dimension];

vR = (float[]) stack.getPixels(1);
vG = (float[]) stack.getPixels(2);
vB = (float[]) stack.getPixels(3);
uB = (float[]) stack.getPixels(4);
uR = (float[]) stack.getPixels(5);

for (int i=0;i<dimension;i++) {
lw[i] = (float) (-0.0067254714510611 +(vR[i]*0.008581802601323981)+(vG[i]*0.0048423272667223564)+(vB[i]*-0.003777454863253943)+(uB[i]*0.0017664795933102907)+(uR[i]*-0.0015037125754572055)+(vR[i]*vG[i]*-2.012454734143212E-5)+(vR[i]*vB[i]*2.0107349126764383E-5)+(vR[i]*uB[i]*-6.348578290549287E-5)+(vR[i]*uR[i]*7.03939070831941E-5)+(vG[i]*vB[i]*4.741361254064237E-6)+(vG[i]*uB[i]*1.0917614428253382E-4)+(vG[i]*uR[i]*-1.2992649687674498E-4)+(vB[i]*uB[i]*-5.372223073215661E-5)+(vB[i]*uR[i]*6.128367240480306E-5)+(uB[i]*uR[i]*3.7167037461946606E-6));
mw[i] = (float) (0.004596919677225305 +(vR[i]*-0.0020000830270183096)+(vG[i]*0.015538984076921482)+(vB[i]*-0.0037489501089860685)+(uB[i]*6.091381177136496E-5)+(uR[i]*-2.610978460727905E-5)+(vR[i]*vG[i]*9.81790833171516E-7)+(vR[i]*vB[i]*8.216670513425579E-6)+(vR[i]*uB[i]*-7.256173993142134E-6)+(vR[i]*uR[i]*3.783559134041039E-6)+(vG[i]*vB[i]*-1.1470963274846385E-5)+(vG[i]*uB[i]*-8.351040168987077E-5)+(vG[i]*uR[i]*7.712379331983669E-5)+(vB[i]*uB[i]*1.1680499267555954E-4)+(vB[i]*uR[i]*-1.060994096807378E-4)+(uB[i]*uR[i]*3.015794195577722E-6));
sw[i] = (float) (8.943390622257047E-4 +(vR[i]*-3.647739983419419E-4)+(vG[i]*-0.002370154863642403)+(vB[i]*0.012069636629397865)+(uB[i]*0.0015423062439695405)+(uR[i]*-0.0010140995731252073)+(vR[i]*vG[i]*-2.5681906383576465E-6)+(vR[i]*vB[i]*7.0295501595011874E-6)+(vR[i]*uB[i]*-3.190795032341929E-5)+(vR[i]*uR[i]*2.9831491747254898E-5)+(vG[i]*vB[i]*-4.624275352347647E-6)+(vG[i]*uB[i]*-3.3894793372995365E-6)+(vG[i]*uR[i]*-1.223153515032232E-6)+(vB[i]*uB[i]*5.389602599148725E-5)+(vB[i]*uR[i]*-4.80229935732674E-5)+(uB[i]*uR[i]*2.521056971861371E-6));
uv[i] = (float) (-2.4275295282641594E-5 +(vR[i]*1.9255078709060275E-4)+(vG[i]*-4.450293685573246E-4)+(vB[i]*7.810956087965122E-4)+(uB[i]*-2.4777633509640235E-4)+(uR[i]*0.009559120503767596)+(vR[i]*vG[i]*-2.475849048584243E-6)+(vR[i]*vB[i]*1.178787476009932E-6)+(vR[i]*uB[i]*8.666051576738324E-6)+(vR[i]*uR[i]*-2.1616320823043714E-5)+(vG[i]*vB[i]*-1.0905528615515864E-6)+(vG[i]*uB[i]*-5.70552329922894E-5)+(vG[i]*uR[i]*7.794753360172207E-5)+(vB[i]*uB[i]*6.673859546539544E-5)+(vB[i]*uR[i]*-6.55042505470064E-5)+(uB[i]*uR[i]*-5.647961706767079E-6));
dbl[i] = (float) (-8.903288035183407E-4 +(vR[i]*0.0012102826456875915)+(vG[i]*0.009567945193043175)+(vB[i]*-9.402992838509788E-4)+(uB[i]*6.840254442398076E-4)+(uR[i]*-6.038774208474995E-4)+(vR[i]*vG[i]*-5.157205383953525E-6)+(vR[i]*vB[i]*7.0229671245899314E-6)+(vR[i]*uB[i]*-3.217534730899858E-5)+(vR[i]*uR[i]*3.430935573134218E-5)+(vG[i]*vB[i]*-7.136523055933723E-7)+(vG[i]*uB[i]*3.488716757762283E-5)+(vG[i]*uR[i]*-4.425257111842605E-5)+(vB[i]*uB[i]*-1.4801767481648457E-6)+(vB[i]*uR[i]*6.9923686513972145E-6)+(uB[i]*uR[i]*1.7418206050148427E-6));
IJ.showProgress((float) i/dimension);
}

ImageStack outStack = new ImageStack(w, h);
outStack.addSlice("lw", lw);
outStack.addSlice("mw", mw);
outStack.addSlice("sw", sw);
outStack.addSlice("uv", uv);
outStack.addSlice("dbl", dbl);
new ImagePlus("Output", outStack).show();

}
}
