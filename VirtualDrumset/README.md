# Java Drumset

## Your very own virtual drumset!

Have you ever wanted to play the drumset, but you just couldn't? Maybe you don't have 
one or, maybe it's too loud. Well, with the Java Drumset you'll never have to worry 
about that again! This program allows you to practice your percussion skills with 
no hassle, all you need is a computer! The Java Drumset comes complete with:

- Snare Drum
- Bass Drum
- Ride and Crash Cymbals
- 3 Tom-Toms
- Open and Closed Hi-Hat

As you can see this program will work for any wannabe drummer! Download the Java 
Drumset today! Happy drumming!

## User Stories
- As a user, I want access to all necessary instruments* in a drumset
- As a user, I want to be able to see what instrument* options I have
- As a user, I want to be able to select what instrument* sound I want
- As a user, I want to be able to create a track and add instruments to it
- As a user, I want to be able to hear my track played back to me
- As a user, I want to be able to save my track to file
- As a user, I want to be able to load my track from file

*Instrument here is referencing the different parts of a drumset

## Phase 4: Task 2
### Example Event Log:
Wed Nov 24 14:21:20 PST 2021
Started recording track.

Wed Nov 24 14:21:21 PST 2021
Added snare to track.

Wed Nov 24 14:21:21 PST 2021
Added closed to track.

Wed Nov 24 14:21:22 PST 2021
Added crash to track.

Wed Nov 24 14:21:22 PST 2021
Added high to track.

Wed Nov 24 14:21:22 PST 2021
Added low to track.

Wed Nov 24 14:21:23 PST 2021
Added bass to track.

Wed Nov 24 14:21:23 PST 2021
Added floor to track.

Wed Nov 24 14:21:24 PST 2021
Added open to track.

Wed Nov 24 14:21:24 PST 2021
Added ride to track.

Wed Nov 24 14:21:25 PST 2021
Stopped recording track.

Wed Nov 24 14:21:28 PST 2021
Played user's track.

Wed Nov 24 14:21:30 PST 2021
Reset track.

###
#### Case Where Log Would Be Empty:
The log could be empty if the user interacts with the drumset interface but never hits the "Record Track"
button and doesn't interact with any of the track control buttons. If the user never clicks "Record Track", 
they can still click the drumset buttons and play the drumset, but instruments will never be added to the track, 
so nothing gets logged. This is because adding instruments to a track is the add X to Y functionality
of the project, so if this never happens, the log has nothing to show.

## Phase 4: Task 3
One thing that sticks out to me first is that I have some coupling with my VirtualDrumsetApp, VirtualDrumsetPanel,
and my Track classes. Given the chance to refactor I would definitely try to remove that coupling.
Another thing that I notice is in my Drumset class. I have individual methods for each of my different
instruments in my drumset. If I ever wanted to add more instruments it would be difficult with how I
currently have the class set up. I would refactor this so that it gets compacted down to one method that
gets an instrument passed to it if it wants to play that instruments sound. Also, in my VirtualDrumsetPanel
class, I feel like I have a lot of extra functions for setting listeners and styling buttons. I think
moving a lot of these components of the panel into their own classes could have helped clean that code
up a little. Finally, I would move implementation of the playSound() function into my instrument class
and just use the Drumset class to set up my drumset with various instruments.