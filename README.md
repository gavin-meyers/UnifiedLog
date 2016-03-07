A unified log is an append-only, ordered,distributed log that allows a company to centralize its continuous event streams.

Append-only means that new events are appended to the front of the unified log, but
existing events are never updated in-place once appended. What about deletion? Events are
automatically deleted from the unified log when they age beyond a configured time window,
but they cannot be deleted in an ad hoc fashion.

Distributed might sound a little confusing: is the log unified, or is it distributed? Actually, it’s
both! Distributed and unified are referring to different properties of the log: the log is unified
because a single unified log implementation at the heart of their business....

The unified log is distributed because it lives across a cluster of individual
machines.

Clustered software tends to be more complex to setup, run and indeed reason about than
software that lives inside one machine. Why do we distribute the log across a cluster? For two
main reasons:

* Scalability – having the unified log distributed across a cluster of machines allows us to
work with event streams larger than the capability of any single machine. This is
important because any given stream of events (e.g. taxi telemetry data from our
example above) could be very large. Distribution across a cluster also makes it easy for
each application reading the unified log to be clustered
* Durability – a unified log will replicate all events within the cluster. Without this event
distribution, the unified log would be vulnerable to data loss