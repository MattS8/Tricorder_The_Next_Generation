package com.tricorder.matt.tricorderthenextgeneration.instruments;

/**
 * Created by Matt on 5/25/2015.
 */

import android.os.Bundle;

import com.tricorder.matt.tricorderthenextgeneration.core.SurfaceRunner;

/**
 * An instrument which measures some quantity, or accesses or produces some
 * data, which can be displayed on one or more {@link Gauge} objects.
 */
public class Instrument
{

    // ******************************************************************** //
    // Constructor.
    // ******************************************************************** //

    /**
     * Set up this view.
     *
     * @param	parent			Parent surface.
     */
    public Instrument(SurfaceRunner parent) {
        parentSurface = parent;
    }


    // ******************************************************************** //
    // Run Control.
    // ******************************************************************** //

    /**
     * The application is starting.  Perform any initial set-up prior to
     * starting the application.
     */
    public void appStart() {
    }


    /**
     * We are starting the main run; start measurements.
     */
    public void measureStart() {
    }


    /**
     * We are stopping / pausing the run; stop measurements.
     */
    public void measureStop() {
    }


    /**
     * The application is closing down.  Clean up any resources.
     */
    public void appStop() {
    }


    // ******************************************************************** //
    // Main Loop.
    // ******************************************************************** //

    /**
     * Update the state of the instrument for the current frame.
     *
     * <p>Instruments may override this, and can use it to read the
     * current input state.  This method is invoked in the main animation
     * loop -- i.e. frequently.
     *
     * @param   now         Nominal time of the current frame in ms.
     */
    protected void doUpdate(long now) {
    }


    // ******************************************************************** //
    // Utilities.
    // ******************************************************************** //

    /**
     * Get the app context of this Element.
     *
     * @return             The app context we're running in.
     */
    protected SurfaceRunner getSurface() {
        return parentSurface;
    }


    // ******************************************************************** //
    // Save and Restore.
    // ******************************************************************** //

    /**
     * Save the state of the game in the provided Bundle.
     *
     * @param   icicle      The Bundle in which we should save our state.
     */
    protected void saveState(Bundle icicle) {
//      gameTable.saveState(icicle);
    }


    /**
     * Restore the game state from the given Bundle.
     *
     * @param   icicle      The Bundle containing the saved state.
     */
    protected void restoreState(Bundle icicle) {
//      gameTable.pause();
//      gameTable.restoreState(icicle);
    }


    // ******************************************************************** //
    // Class Data.
    // ******************************************************************** //

    // Debugging tag.
    @SuppressWarnings("unused")
    private static final String TAG = "instrument";


    // ******************************************************************** //
    // Private Data.
    // ******************************************************************** //

    // The SurfaceRunner we're attached to.
    private final SurfaceRunner parentSurface;

}